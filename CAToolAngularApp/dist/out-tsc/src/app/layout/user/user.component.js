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
var http_1 = require("@angular/common/http");
var user_service_1 = require("./user.service");
var rxjs_1 = require("rxjs");
var DataTablesResponse = /** @class */ (function () {
    function DataTablesResponse() {
    }
    return DataTablesResponse;
}());
var UserComponent = /** @class */ (function () {
    function UserComponent(userService, router, http) {
        this.userService = userService;
        this.router = router;
        this.http = http;
        this.dtOptions = {};
        this.dtTrigger = new rxjs_1.Subject();
        // persons: Person[];
        this.AllData = [];
    }
    UserComponent.prototype.addUser = function () {
        console.log("This is user component");
        console.log(this.IpAddress);
        this.userService.sendIpAddresstoOtherComponent(this.IpAddress);
        this.router.navigate(['/user/add-user']);
    };
    UserComponent.prototype.updateUser = function (user) {
        console.log(user);
        this.userService.sendMsgtoOtherComponent(user);
        this.router.navigate(['/user/update-user']);
    };
    UserComponent.prototype.deleteUser = function (formvalues) {
        console.log(formvalues);
        this.userService.deleteUser(formvalues).subscribe(function (data) {
            console.log(data);
        }, function (error) { return console.log('ERROR: ' + error); });
        this.router.navigate(['/user']);
    };
    UserComponent.prototype.uploadUserInfo = function () {
        console.log(this.IpAddress);
        this.userService.sendIpAddresstoOtherComponent(this.IpAddress);
        this.router.navigate(['/user/upload-user']);
    };
    UserComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.dtOptions = {
            pagingType: 'full_numbers',
            pageLength: 10,
            responsive: true
        };
        this.userService.getIpAddress().subscribe(function (data) {
            _this.IpAddress = data['ip'];
            _this.userService.CollectData().subscribe(function (result) {
                _this.AllData = result;
                _this.dtTrigger.next();
            });
        });
    };
    UserComponent = __decorate([
        core_1.Component({
            selector: 'app-user',
            templateUrl: './user.component.html',
            styleUrls: ['./user.component.scss']
        }),
        __metadata("design:paramtypes", [user_service_1.UsersService,
            router_1.Router,
            http_1.HttpClient])
    ], UserComponent);
    return UserComponent;
}());
exports.UserComponent = UserComponent;
//# sourceMappingURL=user.component.js.map