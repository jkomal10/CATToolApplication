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
var Question_1 = require("../Question");
var assessment_questions_service_1 = require("../assessment-questions.service");
var UpdateQuestionComponent = /** @class */ (function () {
    function UpdateQuestionComponent(assessmentQuestionsService, router) {
        this.assessmentQuestionsService = assessmentQuestionsService;
        this.router = router;
        this.question = new Question_1.AssessmentQuestions();
        this.submitted = false;
    }
    UpdateQuestionComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.assessmentQuestionsService.question.subscribe(function (data) { _this.que = data; });
    };
    UpdateQuestionComponent.prototype.updateQue = function (question) {
        console.log('*******onsubmit application**********' + question.questionId);
        this.assessmentQuestionsService.updateAssessmentQuestions(question)
            .subscribe();
        this.router.navigate(['/assessment-questions']);
    };
    UpdateQuestionComponent.prototype.onSubmit = function (formvalues) {
        this.question = formvalues;
        this.updateQue(this.question);
    };
    UpdateQuestionComponent = __decorate([
        core_1.Component({
            selector: 'app-update-question',
            templateUrl: './update-question.component.html',
            styleUrls: ['./update-question.component.scss']
        }),
        __metadata("design:paramtypes", [assessment_questions_service_1.AssessmentQuestionsService, router_1.Router])
    ], UpdateQuestionComponent);
    return UpdateQuestionComponent;
}());
exports.UpdateQuestionComponent = UpdateQuestionComponent;
//# sourceMappingURL=update-question.component.js.map