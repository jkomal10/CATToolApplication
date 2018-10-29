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
var assessment_questions_service_1 = require("./assessment-questions.service");
var rxjs_1 = require("rxjs");
var Question_1 = require("./Question");
var DataTablesResponse = /** @class */ (function () {
    function DataTablesResponse() {
    }
    return DataTablesResponse;
}());
var AssessmentQuestionsComponent = /** @class */ (function () {
    function AssessmentQuestionsComponent(assessmentQuestionsService, router, http) {
        this.assessmentQuestionsService = assessmentQuestionsService;
        this.router = router;
        this.http = http;
        this.question = new Question_1.AssessmentQuestions();
        this.submitted = false;
        this.dtOptions = {};
        this.dtTrigger = new rxjs_1.Subject();
        this.AllData = [];
    }
    AssessmentQuestionsComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.dtOptions = {
            pagingType: 'full_numbers',
            pageLength: 5,
            responsive: true
        };
        this.assessmentQuestionsService.CollectData().subscribe(function (result) {
            _this.AllData = result;
            _this.dtTrigger.next();
            console.log(_this.AllData);
        });
    };
    AssessmentQuestionsComponent.prototype.importQuestions = function () {
        this.router.navigate(['/assessment-questions/import-question']);
    };
    AssessmentQuestionsComponent.prototype.addQuestions = function () {
        this.router.navigate(['/assessment-questions/add-assessment-question']);
    };
    AssessmentQuestionsComponent.prototype.deleteQuestions = function (formvalues) {
        this.assessmentQuestionsService.deleteQuestion(formvalues)
            .subscribe(function (data) {
            console.log(data);
        }, function (error) { return console.log('ERROR: ' + error); });
        this.router.navigate(['/assessment-questions']);
    };
    AssessmentQuestionsComponent.prototype.updateQuestions = function (questions) {
        this.assessmentQuestionsService.sendMsgtoOtherComponent(questions);
        this.router.navigate(['/assessment-questions/update-question']);
    };
    AssessmentQuestionsComponent.prototype.deactivate = function () {
        this.router.navigate(['/assessment-questions/update-question']);
    };
    AssessmentQuestionsComponent = __decorate([
        core_1.Component({
            selector: 'app-assessment-questions',
            templateUrl: './assessment-questions.component.html',
            styleUrls: ['./assessment-questions.component.scss']
        }),
        __metadata("design:paramtypes", [assessment_questions_service_1.AssessmentQuestionsService, router_1.Router, http_1.HttpClient])
    ], AssessmentQuestionsComponent);
    return AssessmentQuestionsComponent;
}());
exports.AssessmentQuestionsComponent = AssessmentQuestionsComponent;
//# sourceMappingURL=assessment-questions.component.js.map