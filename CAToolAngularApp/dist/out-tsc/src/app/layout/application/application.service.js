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
var ApplicationService = /** @class */ (function () {
    function ApplicationService(http) {
        this.http = http;
        this.deactivateUrl = 'http://localhost:8090/application/deactivateApplicationById';
        this.Baseurl = 'http://localhost:8090/application/deleteApplicationById';
        this.deleteUrl = 'http://localhost:8090/application/resetApplicationById';
        //url:String= 'http://localhost:8090/application/getApplicationById';
        this.url1 = 'http://localhost:8090/application/updateApplictaion';
        this.appCountUrl = "http://localhost:8090/application/getTotalApplicationsCount";
        this.baseUrl = 'http://localhost:8090/application/saveApplication';
        this.comptransfer = new rxjs_1.BehaviorSubject("Hello");
        this.question = this.comptransfer.asObservable();
    }
    ApplicationService.prototype.CollectData = function (clientName) {
        var url = 'http://localhost:8090/application/getAll';
        return this.http.get(url + "/" + clientName);
    };
    ApplicationService.prototype.createApplication = function (application) {
        return this.http.post("" + this.baseUrl + "/create", application);
    };
    ApplicationService.prototype.deleteApplications = function (applicationId) {
        return this.http.delete(this.Baseurl + "/" + applicationId, { responseType: 'text' });
    };
    ApplicationService.prototype.resetApplication = function (applicationId) {
        return this.http.put(this.deleteUrl + "/" + applicationId, { responseType: 'text' });
    };
    ApplicationService.prototype.updateApplication = function (value) {
        console.log('################application.service.');
        console.log('~~~~~~~~~~~~~~~~~~~~~~~~~~' + ("" + this.url1) + '~~~~~~~~~~~~~~~~~~~~~~~');
        return this.http.put("" + this.url1, value);
    };
    ApplicationService.prototype.deactivate = function (applicationId) {
        console.log('################application.service.');
        console.log('~~~~~~~~~~~~~~~~~~~~~~~~~~' + ("" + this.deactivateUrl) + '~~~~~~~~~~~~~~~~~~~~~~~');
        return this.http.put(this.deactivateUrl + "/" + applicationId, { responseType: 'text' });
    };
    ApplicationService.prototype.sendMsgtoOtherComponent = function (messsage) {
        this.comptransfer.next(messsage);
    };
    ApplicationService.prototype.getApplicationCount = function (clientName) {
        return this.http.get(this.appCountUrl + "/" + clientName);
    };
    ApplicationService = __decorate([
        core_1.Injectable({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [http_1.HttpClient])
    ], ApplicationService);
    return ApplicationService;
}());
exports.ApplicationService = ApplicationService;
//# sourceMappingURL=application.service.js.map