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
var Angular5_csv_1 = require("angular5-csv/Angular5-csv");
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
        this.id = '0eWrpsCLMJQ';
        this.dtOptions = {};
        this.dtTrigger = new rxjs_1.Subject();
        // persons: Person[];
        this.users = [];
        this.AllData = [];
    }
    UserComponent.prototype.savePlayer = function (player) {
        this.player = player;
        console.log('Video Url', player.getVideoUrl());
    };
    UserComponent.prototype.onStateChange = function (event) {
        console.log('player state', event.data);
    };
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
    UserComponent.prototype.deactivate = function (formvalues) {
        this.userService.deactivate(formvalues).subscribe();
    };
    UserComponent.prototype.uploadUserInfo = function () {
        console.log(this.IpAddress);
        this.userService.sendIpAddresstoOtherComponent(this.IpAddress);
        this.router.navigate(['/user/upload-user']);
    };
    UserComponent.prototype.exportCsv = function () {
        var filename = "UserDetails";
        for (var index = 0; index < this.AllData.length; index++) {
            this.users[index] = this.AllData[index];
        }
        var options = {
            headers: ["userId", "userName", "firstName", "lastName", "password", "ipAddress", "lastLogin", "company", "isDeleted",
                "isDeactivate", "createdDateTime", "createdBy", "modifiedDateTime", "modifiedBy", "isAdmin"]
        };
        new Angular5_csv_1.Angular5Csv(this.users, filename, options);
    };
    UserComponent.prototype.help = function () {
        // this.userService.sendUsertoOtherComponent("user");
        localStorage.setItem('component', 'user');
        this.router.navigate(['/help']);
    };
    UserComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.clientValue = localStorage.getItem("clientName");
        this.dtOptions = {
            pagingType: 'full_numbers',
            pageLength: 10,
            responsive: true
        };
        this.userService.getIpAddress().subscribe(function (data) {
            _this.IpAddress = data['ip'];
            _this.userService.CollectData(_this.clientValue).subscribe(function (result) {
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