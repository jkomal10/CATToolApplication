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
var for_cloud_provider_service_1 = require("../for-cloud-provider.service");
var Question_1 = require("../../../assessment-questions/Question");
var CloudProviderRuleComponent = /** @class */ (function () {
    function CloudProviderRuleComponent(forCloudProviderService) {
        this.forCloudProviderService = forCloudProviderService;
        this.executionOrders = [];
        this.cloudProviderRulesText = [];
        this.cloudProviderRule = [];
    }
    CloudProviderRuleComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.forCloudProviderService.cloudProviderId.subscribe(function (data) { _this.cloudproviderId = data; });
        console.log(this.cloudproviderId + "Cloud Provider rule component");
        // this.forCloudProviderService.CollectCloudableRuleQuestions(this.cloudproviderId).subscribe( result=>{
        this.forCloudProviderService.CollectCloudableRuleQuestions().subscribe(function (result) {
            _this.CloudProviderAllData = result;
            console.log(_this.CloudProviderAllData);
            console.log("*****CloudProviderAllData");
        });
        console.log("the cloudproviderid is " + this.cloudproviderId);
        // console.log("the providerid we get "+ this.CloudProviderAllData.cloudProviderRules[0].cloudProviderRuleId);
    };
    CloudProviderRuleComponent.prototype.onSubmit = function () {
        this.addCloudeProviderRule();
    };
    CloudProviderRuleComponent.prototype.addCloudeProviderRule = function () {
        for (var index = 0; index < this.CloudProviderAllData.length; index++) {
            var assesmentquestion = new Question_1.AssessmentQuestions;
            assesmentquestion = this.CloudProviderAllData[index];
            var cloudProviderRule1;
            cloudProviderRule1 = this.CloudProviderAllData[index].cloudProviderRules;
            console.log("Rules******" + cloudProviderRule1);
            for (var index1 = 0; index1 < cloudProviderRule1.length; index1++) {
                console.log("ID*******" + assesmentquestion.cloudProviderRules[index1].cloudProviderId);
                // console.log("ID*******"+cloudProviderRule1[index1].cloudProviderId);
            }
            // console.log("cloudproviderLength*****"+assesmentquestion.cloudProviderRules.length);
            // console.log("assesmentquestion*********"+assesmentquestion.cloudProviderRules[index].cloudProviderId);
            // console.log(this.CloudProviderAllData[index].cloudProviderRules[index].cloudProviderId);
            // console.log("length"+this.CloudProviderAllData[index].cloudProviderRules.length);
            // for (let index1 = 0; index1 < this.CloudProviderAllData[index].cloudProviderRules.length; index1++) {
            //   console.log("id*******"+this.CloudProviderAllData[index].cloudProviderRules[index1].cloudProviderId)
            //   // if(this.cloudproviderId==this.CloudProviderAllData[index].cloudProviderRules.cloudProviderId)
            //   // {
            //   console.log(this.CloudProviderAllData[index].questionId+"CloudProviderAllData");
            //   console.log(this.cloudproviderId+"-------this.cloudproviderId");
            //   console.log(this.CloudProviderAllData[index].cloudProviderRules.cloudProviderId+"**********")
            //   var cloudproRules : CloudProviderRule = new CloudProviderRule();
            //   cloudproRules.questionId = this.CloudProviderAllData[index].questionId;
            //   cloudproRules.cloudProviderId = this.cloudproviderId;
            //   cloudproRules.cloudProviderRule = this.cloudProviderRulesText[index];
            //   cloudproRules.executionOrder = this.executionOrders[index];
            //   cloudproRules.questionText = this.CloudProviderAllData[index].questionText;
            //   this.cloudProviderRule[index]= cloudproRules;
            // // }
            // }
        }
        console.log(JSON.stringify(this.cloudProviderRule));
    };
    CloudProviderRuleComponent = __decorate([
        core_1.Component({
            selector: 'app-cloud-provider-rule',
            templateUrl: './cloud-provider-rule.component.html',
            styleUrls: ['./cloud-provider-rule.component.scss']
        }),
        __metadata("design:paramtypes", [for_cloud_provider_service_1.ForCloudProviderService])
    ], CloudProviderRuleComponent);
    return CloudProviderRuleComponent;
}());
exports.CloudProviderRuleComponent = CloudProviderRuleComponent;
//# sourceMappingURL=cloud-provider-rule.component.js.map