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
var user_service_1 = require("../user.service");
var router_1 = require("@angular/router");
var AddUserComponent = /** @class */ (function () {
    function AddUserComponent(userService, router) {
        this.userService = userService;
        this.router = router;
        this.AllData = [];
        this.status = true;
        this.userTypeValue = 1;
        this.userType = "User";
        this.count = 0;
    }
    AddUserComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.clientNameValue = localStorage.getItem('clientName');
        this.userService.getIpAddress().subscribe(function (data) {
            localStorage.setItem('ip', data['ip']);
        });
        this.userService.CollectData(this.clientNameValue).subscribe(function (result) {
            _this.AllData = result;
            console.log(_this.AllData);
        });
    };
    AddUserComponent.prototype.addUserComponent = function (formvalues) {
        this.user = formvalues;
        this.user.isAdmin = this.userTypeValue;
        this.userName = formvalues.userName;
        for (var index = 0; index < this.AllData.length; index++) {
            if (this.userName === this.AllData[index].userName) {
                this.status = false;
                console.log(this.status);
                alert("User already exits, please enter a new name");
                this.router.navigate(['/user']);
            }
        }
        if (this.status) {
            this.user.ipAddress = localStorage.getItem('ip');
            this.user.clientName = this.clientNameValue;
            this.userService.addUser(this.user).subscribe();
            this.router.navigate(['/user']);
        }
    };
    AddUserComponent.prototype.selectChangeHandler = function (event) {
        if (event.target.value == "User") {
            console.log("User is Admin=1");
            this.userTypeValue = 1;
            this.user.isAdmin = 1;
            this.userType = "User";
        }
        else {
            console.log("Admin is Admin=0");
            this.userTypeValue = 0;
            this.user.isAdmin = 0;
            this.userType = "Admin";
        }
    };
    AddUserComponent = __decorate([
        core_1.Component({
            selector: 'app-add-user',
            templateUrl: './add-user.component.html',
            styleUrls: ['./add-user.component.scss']
        }),
        __metadata("design:paramtypes", [user_service_1.UsersService, router_1.Router])
    ], AddUserComponent);
    return AddUserComponent;
}());
exports.AddUserComponent = AddUserComponent;
//# sourceMappingURL=add-user.component.js.map