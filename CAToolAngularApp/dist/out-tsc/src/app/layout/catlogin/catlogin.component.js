"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var router_animations_1 = require("../../router.animations");
var catlogin_service_1 = require("./catlogin.service");
var Users_1 = require("./Users");
var localStorage_service_1 = require("../utility/service/localStorage.service");
var CATloginComponent = /** @class */ (function () {
    function CATloginComponent(loginService, router, myStorage) {
        this.loginService = loginService;
        this.router = router;
        this.myStorage = myStorage;
        this.users = new Users_1.Users();
    }
    CATloginComponent.prototype.ngOnInit = function () { };
    CATloginComponent.prototype.onLoggedin = function (formValues) {
        var _this = this;
        this.loginService.getUserByUserNamePassword(formValues.userName, formValues.password).subscribe(function (data) {
            _this.users = data;
            if (_this.users != null) {
                _this.myStorage.setLoggedInTrue('true'); //set is logged in true in session
                _this.myStorage.setCurrentUserObject(_this.users); //set current user object in session
                if (_this.users.isAdmin === 0) {
                    localStorage.setItem('userName', formValues.userName);
                    _this.myStorage.setIsUserActive('true');
                    _this.message = "admin";
                    _this.loginService.sendMsgtoOtherComponent(_this.users);
                    _this.router.navigate(['/dashboard']);
                }
                else if (_this.users.isAdmin == 1) {
                    _this.myStorage.setIsUserActive('false');
                    _this.loginService.sendMsgtoOtherComponent(_this.users.userId);
                    _this.loginService.sendMsgtoOtherComponent(_this.users);
                    _this.router.navigate(['/dashboard']);
                }
            }
            else {
                alert("Please enter correct username and Password");
            }
        });
    };
    CATloginComponent = __decorate([
        core_1.Component({
            selector: 'app-catlogin',
            templateUrl: './catlogin.component.html',
            styleUrls: ['./catlogin.component.scss'],
            animations: [router_animations_1.routerTransition()]
        }),
        __metadata("design:paramtypes", [catlogin_service_1.CatloginService, router_1.Router, localStorage_service_1.LocalStorageService])
    ], CATloginComponent);
    return CATloginComponent;
}());
exports.CATloginComponent = CATloginComponent;
//# sourceMappingURL=catlogin.component.js.map