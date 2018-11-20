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
        this.optionsValues = [1, 2, 3, 4, 5, 6, 7, 8, 9];
        this.Options = [10];
        this.OptionsArray = [];
    }
    UpdateQuestionComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.assessmentQuestionsService.question.subscribe(function (data) { _this.que = data; });
        this.question = this.que;
        this.numberOfOptions = 0;
        var option = this.optionsValues;
        this.numberOfOptions = this.question.questionOption.length;
        console.log(this.question.questionOption.length + "*************");
        this.selectChangeHandlerDefault(this.numberOfOptions);
        console.log(JSON.stringify(this.question.questionOption));
    };
    UpdateQuestionComponent.prototype.selectChangeHandlerDefault = function (value) {
        console.log("option value " + value);
        this.numberOfOptions = value;
        console.log(this.numberOfOptions);
        console.log();
        for (var index = 1; index <= this.numberOfOptions; index++) {
            console.log(index);
            this.Options[index] = index;
            console.log(this.Options);
            console.log(this.Options.length);
        }
    };
    UpdateQuestionComponent.prototype.selectChangeHandler = function (event) {
        console.log(event.target.value + "********");
        this.numberOfOptions = parseInt(event.target.value, 10);
        console.log(this.numberOfOptions);
        console.log(event.target.value);
        for (var index = 1; index <= this.numberOfOptions; index++) {
            console.log(index);
            this.Options[index] = index;
            console.log(this.Options);
            console.log(this.Options.length);
        }
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