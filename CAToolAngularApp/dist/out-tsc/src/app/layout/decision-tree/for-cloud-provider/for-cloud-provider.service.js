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
var ForCloudProviderService = /** @class */ (function () {
    function ForCloudProviderService(http) {
        this.http = http;
        this.evaluationOrder = 'http://localhost:8090/cloudProvider';
        // private cloudProviderRuleUrl = 'http://localhost:8090/cloudProvider/getAllCloudProviderQuestion';
        this.updateCloudProviderRuleUrl = "http://localhost:8090/cloudProvider/updateCloudProviderRule";
        this.comptransfer = new rxjs_1.BehaviorSubject("Hello");
        this.cloudProviderId = this.comptransfer.asObservable();
    }
    ForCloudProviderService.prototype.CollectData = function () {
        this.clientNameValue = localStorage.getItem('clientName');
        var url = 'http://localhost:8090/cloudProvider/getAll';
        return this.http.get(url + "/" + this.clientNameValue);
    };
    ForCloudProviderService.prototype.saveEvaluationOrder = function (evaluationOrder) {
        console.log(this.evaluationOrder);
        return this.http.put("" + this.evaluationOrder + "/setEvaluationOrder", evaluationOrder);
    };
    ForCloudProviderService.prototype.sendCloudProviderIdtoOtherComponent = function (messsage) {
        this.comptransfer.next(messsage);
    };
    ForCloudProviderService.prototype.CollectCloudableRuleQuestions = function (cloudproviderId) {
        this.clientNameValue = localStorage.getItem('clientName');
        return this.http.get("http://localhost:8090/assessmentQuestions/getAllCloudProviderRule/" + cloudproviderId + "/" + this.clientNameValue);
    };
    ForCloudProviderService.prototype.updateCloudProviderRule = function (cloudableRule) {
        this.clientNameValue = localStorage.getItem('clientName');
        return this.http.put("" + this.updateCloudProviderRuleUrl + "/" + this.clientNameValue, cloudableRule);
    };
    ForCloudProviderService = __decorate([
        core_1.Injectable({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [http_1.HttpClient])
    ], ForCloudProviderService);
    return ForCloudProviderService;
}());
exports.ForCloudProviderService = ForCloudProviderService;
//# sourceMappingURL=for-cloud-provider.service.js.map