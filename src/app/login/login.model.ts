export class Login{
    constructor(
                public userId: string,
                public _expirationDate: Date){
    }

    getExpirationDate(){
        //Check token expiry date
        if(new Date() > this._expirationDate){
            return null;
        }
        return true;
    }
}