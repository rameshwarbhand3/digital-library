import { useEffect, useState } from "react"
import BookModel from "../../models/BookModel"
import { SpinnerLoading } from "../Utils/SpinnerLoading";
import { StarsReviews } from "../Utils/StarsReviews";
import { CheckoutAndReviewBox } from "./CheckoutAndReviewBox";
import ReviewModel from "../../models/ReviewModel";
import { LatestReviews } from "./LatestReviews";
import { useOktaAuth } from "@okta/okta-react";
import ReviewRequestModel from "../../models/ReviewRequestModel";

export const BookCheckoutPage = () => {

    const { authState } = useOktaAuth();

    const [book, setBook] = useState<BookModel>();
    const [isLoading, setIsLoading] = useState(true);
    const [httpError, setHttpError] = useState(null);

    //Review state
    const [reviews, setReviews] = useState<ReviewModel[]>([]);
    const [totalStars, setTotalStars] = useState(0);
    const [isLoadingReview, setIsLoadingReview] = useState(true);

    const [isReviewLeft, setIsReviewLeft] = useState(false);
    const [isLoadingUserReview, setIsLoadingUserReview] = useState(true);

    //Loan count state
    const [currentLoansCount, setCurrentLoansCount] = useState(0);
    const [isLoadingCurrentLoanCount, setIsLoadingCurrentLoanCount] = useState(true);

    //Is book checked out?
    const [isCheckedOut, setIsCheckedout] = useState(false);
    const [isLoadingBookCheckedout, setIsLoadingBookCheckedout] = useState(true);

    //Payment
    const [displayError,setDisplayError] = useState(false);

    const bookId = (window.location.pathname).split("/")[2];

    useEffect(() => {
        const fetchBooks = async () => {

            const baseUrl: string = `${process.env.REACT_APP_API}/books/${bookId}`;

            const response = await fetch(baseUrl);

            if (!response.ok) {
                throw new Error('Something went wrong!');
            }

            const responseJson = await response.json();

            const loadedBook: BookModel = {
                id: responseJson.id,
                title: responseJson.title,
                author: responseJson.author,
                description: responseJson.description,
                copies: responseJson.copies,
                copiesAvailable: responseJson.copiesAvailable,
                category: responseJson.category,
                img: responseJson.img,
            }

            setBook(loadedBook);
            setIsLoading(false);
        };

        fetchBooks().catch((error: any) => {
            setIsLoading(false);
            setHttpError(error.message);
        })
    }, [isCheckedOut]);


    useEffect(() => {
        const fetchBookReviews = async () => {

            const baseUrl: string = `${process.env.REACT_APP_API}/reviews/search/findByBookId?bookId=${bookId}`;

            const responseReviews = await fetch(baseUrl);

            if (!responseReviews.ok) {
                throw new Error('Something went wrong!');
            }


            const responseJsonReviews = await responseReviews.json();
            const responseData = responseJsonReviews._embedded.books;
            const loadedReviews: ReviewModel[] = [];

            let weightedStarReviews: number = 0;

            for (const key in responseData) {
                loadedReviews.push({
                    id: responseData[key].id,
                    userEmail: responseData[key].userEmail,
                    date: responseData[key].date,
                    rating: responseData[key].rating,
                    bookId: responseData[key].bookId,
                    reviewDescription: responseData[key].reviewDescription
                })
                weightedStarReviews += responseData[key].rating;
            }
            if (loadedReviews) {
                const round = (Math.round((weightedStarReviews / loadedReviews.length) * 2) / 2).toFixed(1);
                setTotalStars(Number(round));
            }
            setReviews(loadedReviews);
            setIsLoadingReview(false);
        };
        fetchBookReviews().catch((error: any) => {
            setIsLoadingReview(false);
            setHttpError(error.message);
        })

    }, [isReviewLeft]);

    useEffect(() => {
        const fetchUserReviewBook = async () => {
            if (authState && authState.isAuthenticated) {
                const url = `${process.env.REACT_APP_API}/reviews/secure/user/book?bookId=${bookId}`;
                const requestOptions = {
                    method: 'GET',
                    headers: {
                        Authorization: `Bearer ${authState.accessToken?.accessToken}`,
                        'Content-Type': 'application/json'
                    }
                };
                const userReview = await fetch(url, requestOptions);
                if (!userReview.ok) {
                    throw new Error("Something went wrong");

                }
                const userReviewResponseJson = await userReview.json();
                setIsReviewLeft(userReviewResponseJson);
            }
            setIsLoadingUserReview(false);
        }
        fetchUserReviewBook().catch((error: any) => {
            setIsLoadingUserReview(false);
            setHttpError(error.message);
        })

    }, [authState]);

    useEffect(() => {
        const fetchUserCurrentLoanCount = async () => {
            if (authState && authState.isAuthenticated) {
                const url = `${process.env.REACT_APP_API}/books/secure/currentLoans/count`;
                const requestOptions = {
                    method: 'GET',
                    headers: {
                        Authorization: `Bearer ${authState.accessToken?.accessToken}`,
                        'Content-Type': 'application/json'
                    }
                };
                const currentLoansCountResponse = await fetch(url, requestOptions);
                if (!currentLoansCountResponse.ok) {
                    throw new Error("Something went wrong");
                }
                const currentLoansCountResponseJson = await currentLoansCountResponse.json();
                setCurrentLoansCount(currentLoansCountResponseJson);
            }
            setIsLoadingCurrentLoanCount(false);

        }
        fetchUserCurrentLoanCount().catch((error: any) => {
            setIsLoadingCurrentLoanCount(false);
            setHttpError(error.message);
        })

    }, [authState, isCheckedOut]);

    useEffect(() => {
        const fetchUserCheckedoutBook = async () => {
            if (authState && authState.isAuthenticated) {
                const url = `${process.env.REACT_APP_API}/books/secure/checkout?bookId=${bookId}`;
                const requestOptions = {
                    method: 'GET',
                    headers: {
                        Authorization: `Bearer ${authState.accessToken?.accessToken}`,
                        'Content-Type': 'application/json'
                    }
                };
                const bookCheckedoutResponse = await fetch(url, requestOptions);
                if (!bookCheckedoutResponse.ok) {
                    throw new Error("Something went wrong");
                }
                const bookCheckedoutResponseJson = await bookCheckedoutResponse.json();
                setIsCheckedout(bookCheckedoutResponseJson);

            }
            setIsLoadingBookCheckedout(false);

        }
        fetchUserCheckedoutBook().catch((error: any) => {
            setIsLoadingBookCheckedout(false);
            setHttpError(error.message);
        })
    }, [authState]);

    // console.log("Inside isLoading " +isLoading);
    // console.log("Inside isLoadingReview "+isLoadingReview);
    // console.log("Inside isLoadingCurrentCount "+isLoadingCurrentLoanCount);
    // console.log("Inside isLoadingBookChekout "+isLoadingBookCheckedout);


    if (isLoading || isLoadingReview || isLoadingCurrentLoanCount || isLoadingBookCheckedout || isLoadingUserReview) {
        console.log("Inside spinnerloading if");
        return (
            <SpinnerLoading />
        )
    }



    if (httpError) {
        return (
            <div className='container m-5'>
                <p>{httpError}</p>
            </div>
        )

    }

    async function checkoutBook() {
        const url = `${process.env.REACT_APP_API}/books/secure/checkout?bookId=${bookId}`;
        const requestOptions = {
            method: 'PUT',
            headers: {
                Authorization: `Bearer ${authState?.accessToken?.accessToken}`,
                "Content-Type": 'application/json'
            }
        }
        const checkoutResponse = await fetch(url, requestOptions);
        if (!checkoutResponse.ok) {
            setDisplayError(true);
            throw new Error("Something went wrong");
        }
        setDisplayError(false);
        setIsCheckedout(true);

    }

    async function submitReview(starInput: number, reviewDescription: string) {
        let bookId: number = 0;
        if (book?.id) {
            bookId = book.id;
        }
        const reviewRequestModel = new ReviewRequestModel(starInput, bookId, reviewDescription);
        const url = `${process.env.REACT_APP_API}/reviews/secure`;
        const requestOptions = {
            method: 'POST',
            headers: {
                Authorization: `Bearer ${authState?.accessToken?.accessToken}`,
                "Content-Type": 'application/json'
            },
            body:JSON.stringify(reviewRequestModel)
        }
        const submitReviewResponse = await fetch(url,requestOptions);
        if(!submitReviewResponse.ok){
            throw new Error("Something went wrong");

        }
        setIsReviewLeft(true);
    }

    return (
        <div>
            <div className="container d-none d-lg-block">
                {
                    displayError && <div className="alert alert-danger mt-3"role="alert">
                        Please pay outstanding fees and/or return late book(s);
                    </div>
                }
                <div className="row mt-5">
                    <div className="col-sm-2 col-md-2">
                        {
                            book?.img ?
                                <img src={book?.img} width='226' height='349' alt="Book" />
                                :
                                <img src={require('./../../Images/BooksImages/book-luv2code-1000.png')} width='226' height='349'
                                    alt="Book" />
                        }
                    </div>
                    <div className="col-4 col-md-4 container">
                        <div className="ml-2">
                            <h2>{book?.title}</h2>
                            <h5 className="text-primary">{book?.author}</h5>
                            <p className="lead">{book?.description}</p>
                            <StarsReviews rating={totalStars} size={32} />
                        </div>
                    </div>
                    <CheckoutAndReviewBox book={book} mobile={false} currentLoansCount={currentLoansCount}
                        isAuthenticated={authState?.isAuthenticated} isCheckedout={isCheckedOut}
                        checkoutBook={checkoutBook} isReviewLeft={isReviewLeft} submitReview={submitReview}/>
                </div>
                <hr></hr>
                <LatestReviews reviews={reviews} bookId={book?.id} mobile={false} />
            </div>

        </div>
    )
}