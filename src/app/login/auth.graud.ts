import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { map } from "rxjs/operators";
import { Observable } from "rxjs";
import { AuthService } from "./auth.service";

@Injectable({
    providedIn: 'root'
})

export class AuthGraud implements CanActivate {

    constructor(private authService: AuthService, private router: Router){

    }
    canActivate(route: ActivatedRouteSnapshot
        , router: RouterStateSnapshot):
        boolean |
        UrlTree |
        Promise<boolean | UrlTree> |
        Observable<boolean | UrlTree> {
            return this.authService.loginStatus.pipe(
                map(loginStatus => {
                    let isLogin: any = !!loginStatus;
                    if(isLogin){
                        return true;
                    }
                    return this.router.createUrlTree(['/login']);
                })
            );
    }
}