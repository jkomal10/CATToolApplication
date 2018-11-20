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
var http_1 = require("@angular/common/http");
var rxjs_1 = require("rxjs");
// import 'rxjs/add/observable/merge';
// import 'rxjs/add/operator/map';
var UsersService = /** @class */ (function () {
    function UsersService(http) {
        this.http = http;
        this.addUserURL = 'http://localhost:8090/user/addUser';
        this.addUrl = 'http://localhost:8090/user/addUser';
        this.updateUrl = 'http://localhost:8090/user/updateUser';
        this.deleteUrl = 'http://localhost:8090/user/deleteUserById';
        this.changePasswordUrl = 'http://localhost:8090/user/changePassword';
        this.deactivateUrl = 'http://localhost:8090/user/deactivateUser';
        this.newAddURL = 'http://localhost:8090/user/addUser';
        this.comptransfer = new rxjs_1.BehaviorSubject("Hello");
        this.users = this.comptransfer.asObservable();
    }
    UsersService.prototype.CollectData = function (clientName) {
        var url = 'http://localhost:8090/user/getAll';
        return this.http.get(url + "/" + clientName);
    };
    UsersService.prototype.countNumberOfUsers = function () {
        var getCount = 'http://localhost:8090/user/getUserCount';
        return this.http.get(getCount);
    };
    UsersService.prototype.addUser = function (application) {
        return this.http.post("" + this.newAddURL + "/create/" + localStorage.getItem('userName'), application);
    };
    UsersService.prototype.deactivate = function (userId) {
        console.log('************deactivate ********');
        return this.http.put(this.deactivateUrl + "/" + userId, { responseType: 'text' });
    };
    UsersService.prototype.changePassword = function (userName, password, newPassword) {
        console.log("" + this.changePasswordUrl + "/" + userName + "/" + password + "/" + newPassword);
        return this.http.get("" + this.changePasswordUrl + "/" + userName + "/" + password + "/" + newPassword);
    };
    UsersService.prototype.sendUsertoOtherComponent = function (messsage) {
        this.comptransfer.next(messsage);
    };
    UsersService.prototype.sendMsgtoOtherComponent = function (messsage) {
        this.comptransfer.next(messsage);
    };
    UsersService.prototype.sendIpAddresstoOtherComponent = function (messsage) {
        this.comptransfer.next(messsage);
    };
    UsersService.prototype.updateUser = function (user) {
        return this.http.put("" + this.updateUrl + "/update/" + localStorage.getItem('userName'), user);
    };
    UsersService.prototype.deleteUser = function (userId) {
        return this.http.delete(this.deleteUrl + "/" + userId, { responseType: 'text' });
    };
    UsersService.prototype.getIpAddress = function () {
        // const headers = new HttpHeaders({ 'Content-Type': 'application/json' ,'Origin' : 'http://localhost:3000', "Access-Control-Allow-Origin" : "*" });
        var headers = new http_1.HttpHeaders({ "Access-Control-Allow-Origin": "*" });
        return this.http.get('http://ipinfo.io');
    };
    UsersService.prototype.handleError = function (error) {
        //Log error in the browser console
        console.error('observable error: ', error);
        return rxjs_1.Observable.throw(error);
    };
    UsersService = __decorate([
        core_1.Injectable({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [http_1.HttpClient])
    ], UsersService);
    return UsersService;
}());
exports.UsersService = UsersService;
//# sourceMappingURL=user.service.js.map