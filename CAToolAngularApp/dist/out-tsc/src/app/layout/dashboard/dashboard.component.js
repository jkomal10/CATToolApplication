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
var router_animations_1 = require("../../router.animations");
var user_service_1 = require("../user/user.service");
var router_1 = require("@angular/router");
var application_service_1 = require("../application/application.service");
var localStorage_service_1 = require("../utility/service/localStorage.service");
var DashboardComponent = /** @class */ (function () {
    function DashboardComponent(userService, applicationService, router, myStorage) {
        this.userService = userService;
        this.applicationService = applicationService;
        this.router = router;
        this.myStorage = myStorage;
        this.isActive = false;
        this.alerts = [];
        this.sliders = [];
        this.application = [];
        this.id = '0eWrpsCLMJQ';
    }
    DashboardComponent.prototype.savePlayer = function (player) {
        this.player = player;
        console.log('Video Url', player.getVideoUrl());
    };
    DashboardComponent.prototype.onStateChange = function (event) {
        console.log('player state', event.data);
    };
    DashboardComponent.prototype.download = function () {
    };
    DashboardComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.clientNameValue = this.myStorage.getClient();
        this.redirectToDashboard = this.myStorage.getLoggedInTrue(); //this.status=localStorage.getItem('isLoggedin');
        if (this.redirectToDashboard == 'true') {
            this.firstName = this.myStorage.getFirstNameOfCurrentUser();
            this.lastName = this.myStorage.getLastNameOfCurrentUser();
            this.userService.CollectData(this.clientNameValue).subscribe(function (data) { _this.users = data; });
            this.applicationService.CollectData(this.clientNameValue).subscribe(function (data) { _this.application = data; });
            this.userActive = this.myStorage.getIsUserActive();
            if (this.userActive == 'false') {
                this.userCheck = false;
            }
            else {
                this.userCheck = true;
            }
        }
        else {
            this.router.navigate(['/login']);
        }
    };
    DashboardComponent.prototype.closeAlert = function (alert) {
        var index = this.alerts.indexOf(alert);
        this.alerts.splice(index, 1);
    };
    DashboardComponent = __decorate([
        core_1.Component({
            selector: 'app-dashboard',
            templateUrl: './dashboard.component.html',
            styleUrls: ['./dashboard.component.scss'],
            animations: [router_animations_1.routerTransition()]
        }),
        __metadata("design:paramtypes", [user_service_1.UsersService, application_service_1.ApplicationService, router_1.Router, localStorage_service_1.LocalStorageService])
    ], DashboardComponent);
    return DashboardComponent;
}());
exports.DashboardComponent = DashboardComponent;
//# sourceMappingURL=dashboard.component.js.map