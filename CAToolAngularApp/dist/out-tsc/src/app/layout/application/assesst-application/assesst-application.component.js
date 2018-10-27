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
var rxjs_1 = require("rxjs");
var assesst_application_service_1 = require("./assesst-application.service");
var AssesstApplicationComponent = /** @class */ (function () {
    function AssesstApplicationComponent(router, assessmentService) {
        this.router = router;
        this.assessmentService = assessmentService;
        this.dtOptions = {};
        this.dtTrigger = new rxjs_1.Subject();
        this.numberOfOption = [];
        this.theCheckboxOptions = [];
        this.theCheckbox = new Array();
        this.temp = [];
    }
    AssesstApplicationComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.dtOptions = {
            pagingType: 'full_numbers',
            pageLength: 2,
            responsive: true
        };
        this.assessmentService.CollecOptiontData().subscribe(function (result) {
            _this.AllData = result;
            _this.dtTrigger.next();
            console.log(_this.AllData);
            console.log(_this.AllData[0].optionText);
            console.log(_this.AllData[1].optionText);
            console.log(_this.AllData[0].assessmentQuestions.questionType);
            console.log(_this.AllData[0].assessmentQuestions.questionText);
        });
        console.log(this.numberOfOption);
        console.log(this.theCheckboxOptions);
    };
    AssesstApplicationComponent.prototype.selectChangeHandler = function (event, index) {
        this.theCheckbox[index] = event;
        console.log(this.theCheckbox);
        // this.theCheckboxOptions = event;
        // console.log("this.theCheckboxOptions"+this.theCheckboxOptions[0]);
        console.log(event);
    };
    AssesstApplicationComponent = __decorate([
        core_1.Component({
            selector: 'app-assesst-application',
            templateUrl: './assesst-application.component.html',
            styleUrls: ['./assesst-application.component.scss']
        }),
        __metadata("design:paramtypes", [router_1.Router, assesst_application_service_1.AssesstApplicationService])
    ], AssesstApplicationComponent);
    return AssesstApplicationComponent;
}());
exports.AssesstApplicationComponent = AssesstApplicationComponent;
//# sourceMappingURL=assesst-application.component.js.map