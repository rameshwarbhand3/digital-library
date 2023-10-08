import ReactDOM from 'react-dom/client';
import './index.css';
import { App } from './App';
import { BrowserRouter } from 'react-router-dom';
import { Elements } from '@stripe/react-stripe-js';
import { loadStripe } from '@stripe/stripe-js';


const stripePromise = loadStripe('pk_test_51NyX9RSAY47trCcrEOy8Cv31H3JbU1DsrrEpmJyBC5DwLiI8grgAWm3drKKGjTYd3zvuUEDwvwHWaaBbvPKQ8hJH00hR6Dxdmk');



const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
 <BrowserRouter>
 <Elements stripe={stripePromise}>
    <App />
    </Elements>
  </BrowserRouter>
);
