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
    }
    AddUserComponent.prototype.ngOnInit = function () {
        this.userService.getIpAddress().subscribe(function (data) {
            localStorage.setItem('ip', data['ip']);
        });
    };
    AddUserComponent.prototype.addUserComponent = function (formvalues) {
        this.user = formvalues;
        this.user.ipAddress = localStorage.getItem('ip');
        this.userService.addUser(this.user).subscribe();
        this.router.navigate(['/user']);
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