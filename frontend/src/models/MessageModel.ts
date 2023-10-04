class MessageModel{
    title:String;
    question:String;
    id?:number;
    userEmail?:String;
    adminEmail?:String;
    response?:String;
    closed?:boolean;

    constructor( title:string, question:string){
        this.title = title;
        this.question = question;
    }

}

export default MessageModel;