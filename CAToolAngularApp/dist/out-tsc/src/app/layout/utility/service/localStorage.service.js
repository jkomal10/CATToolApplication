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
var LocalStorageService = /** @class */ (function () {
    function LocalStorageService(http) {
        this.http = http;
    }
    LocalStorageService.prototype.setCurrentUser = function (currentUser) {
        localStorage.setItem('userName', currentUser);
    };
    LocalStorageService.prototype.setIsAdmin = function (trueFalseValue) {
        localStorage.setItem('isUserActive', trueFalseValue);
    };
    LocalStorageService.prototype.setClient = function (clientName) {
        localStorage.setItem('clientName', clientName);
    };
    LocalStorageService.prototype.setFirstNameOfCurrentUser = function (currentUserfirstName) {
        localStorage.setItem('firstName', currentUserfirstName);
    };
    LocalStorageService.prototype.setLastNameOfCurrentUser = function (currentUserlastName) {
        localStorage.setItem('lastName', currentUserlastName);
    };
    LocalStorageService.prototype.getCurrentUser = function () {
        return localStorage.getItem('userName');
    };
    LocalStorageService.prototype.getIsAdmin = function () {
        return localStorage.getItem('isUserActive');
    };
    LocalStorageService.prototype.getClient = function () {
        return localStorage.getItem('clientName');
    };
    LocalStorageService.prototype.getFirstNameOfCurrentUser = function () {
        return localStorage.getItem('firstName');
    };
    LocalStorageService.prototype.getLastNameOfCurrentUser = function () {
        return localStorage.getItem('lastName');
    };
    LocalStorageService = __decorate([
        core_1.Injectable({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [http_1.HttpClient])
    ], LocalStorageService);
    return LocalStorageService;
}());
exports.LocalStorageService = LocalStorageService;
//# sourceMappingURL=localStorage.service.js.map