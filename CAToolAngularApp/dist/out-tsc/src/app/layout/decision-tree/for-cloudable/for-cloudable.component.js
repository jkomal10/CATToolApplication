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
var for_cloudable_service_1 = require("./for-cloudable.service");
var rxjs_1 = require("rxjs");
var router_1 = require("@angular/router");
var CloudableRule_1 = require("./CloudableRule");
var DataTablesResponse = /** @class */ (function () {
    function DataTablesResponse() {
    }
    return DataTablesResponse;
}());
var ForCloudableComponent = /** @class */ (function () {
    function ForCloudableComponent(http, forCloudableService, router) {
        this.http = http;
        this.forCloudableService = forCloudableService;
        this.router = router;
        this.dtOptions = {};
        this.dtTrigger = new rxjs_1.Subject();
        this.rules = [];
        this.options = [];
        this.optionValues = [];
        this.questions = [];
        //option: QuestionOption=new QuestionOption();
        //op :object [];
        //assessmentQuestions : object [];
        this.message = '';
        //length = this.AllData.length;
        this.executionOrders = [];
        this.cloudableRulesText = [];
        this.cloudableRules = [];
        this.exeorder = [];
        this.cloudableRules = [];
    }
    ForCloudableComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.dtOptions = {
            pagingType: 'full_numbers',
            pageLength: 2,
            responsive: true,
            rowCallback: function (row, data, index) {
                var self = _this;
                // Unbind first in order to avoid any duplicate handler
                // (see https://github.com/l-lin/angular-datatables/issues/87)
                $('td', row).unbind('click');
                $('td', row).bind('click', function () {
                    self.someClickHandler(data);
                });
                return row;
            }
        };
        this.forCloudableService.CollectData().subscribe(function (result) {
            _this.AllData = result;
            _this.dtTrigger.next();
            console.log(_this.AllData);
            var abc = result[0];
            //this.op = abc['questionOption'];
            //console.log(this.op[0]['optionText']+"komalll");
        });
        this.forCloudableService.collectRule().subscribe(function (result) {
            _this.rules = result;
        });
        // for (let index = 0; index < this.rules.length; index++) {
        //   this.exeorder[index]=this.rules[index].executionOrder;
        // }
        // console.log("exeorder***********"+this.exeorder);
        this.forCloudableService.collectQuestion().subscribe(function (result) {
            _this.questions = result;
            console.log(_this.questions);
        });
        this.forCloudableService.collectOptions().subscribe(function (result) {
            _this.options = result;
            console.log(_this.options);
            //  for (let index = 0; index < this.rules.length; index++) {
            //    var qid=this.rules[index].questionId;
            //    for (let index = 0; index < this.options.length; index++) {
            //      if(qid==this.options[index].questionId)
            //      {
            //       var ops= ops+""+this.options[index].optionText;
            //       console.log("&&&&&& **"+ops);
            //      }
            //      this.optionValues[index]=this.ops;
            //     //  console.log("************   "+this.optionValues);
            //    }
            //  }
        });
    };
    ForCloudableComponent.prototype.someClickHandler = function (info) {
        this.message = info.id + ' - ' + info.firstName;
    };
    ForCloudableComponent.prototype.addCloudableRule = function () {
        for (var index = 0; index < this.rules.length; index++) {
            console.log(this.rules[index].questionId + "*********  qid");
            var cRule = new CloudableRule_1.CloudableRule();
            cRule.questionId = this.rules[index].questionId;
            console.log(cRule.questionId + "ruleqid");
            cRule.cloudableRule = this.cloudableRulesText[index];
            console.log("rules***" + cRule.cloudableRule);
            cRule.executionOrder = this.executionOrders[index];
            console.log("exeorder****" + cRule.executionOrder);
            cRule.questionText = this.rules[index].questionText;
            console.log("qtext****" + cRule.questionText);
            cRule.cloudableRuleId = this.rules[index].cloudableRuleId;
            console.log("ruleId***" + cRule.cloudableRuleId);
            this.cloudableRules[index] = cRule;
            this.router.navigate(['/for-cloudable']);
        }
        //console.log(cloudableRules+"llllllllllllllllllllllllllllllllll");
        console.log("jjjjjjjjjjjjjjjjjjjj");
        console.log(JSON.stringify(this.cloudableRules) + "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        this.forCloudableService.addClodableRule(this.cloudableRules).subscribe();
    };
    ForCloudableComponent.prototype.onSubmit = function () {
        // console.log(formvalues[0]);
        //console.log(JSON.stringify(formvalues[0])+"formmmmmmmmmmmmmmmmmmmmm");
        var cRule = new CloudableRule_1.CloudableRule();
        //console.log(cloudableRule+"6666666666666666")
        //this.option=formvalues;
        //this.cloudableRules.push(cloudableRule);
        this.addCloudableRule();
    };
    ForCloudableComponent.prototype.Cancle = function () {
        this.router.navigate(['/decision-tree']);
    };
    ForCloudableComponent = __decorate([
        core_1.Component({
            selector: 'app-for-cloudable',
            templateUrl: './for-cloudable.component.html',
            styleUrls: ['./for-cloudable.component.scss']
        }),
        __metadata("design:paramtypes", [http_1.HttpClient, for_cloudable_service_1.ForCloudableService, router_1.Router])
    ], ForCloudableComponent);
    return ForCloudableComponent;
}());
exports.ForCloudableComponent = ForCloudableComponent;
//# sourceMappingURL=for-cloudable.component.js.map