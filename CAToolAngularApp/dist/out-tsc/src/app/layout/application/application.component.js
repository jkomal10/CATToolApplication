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
var rxjs_1 = require("../../../../node_modules/rxjs");
var application_service_1 = require("./application.service");
var http_1 = require("@angular/common/http");
var Angular5_csv_1 = require("angular5-csv/Angular5-csv");
var DataTablesResponse = /** @class */ (function () {
    function DataTablesResponse() {
    }
    return DataTablesResponse;
}());
var ApplicationComponent = /** @class */ (function () {
    function ApplicationComponent(router, applicationService, http) {
        this.router = router;
        this.applicationService = applicationService;
        this.http = http;
        this.dtOptions = {};
        this.dtTrigger = new rxjs_1.Subject();
        this.message = '';
        //applictaions: Observable<Application[]>;
        this.application = [];
        this.applicationTemplate = [];
        this.AllData = [];
        this.show = false;
        this.buttonName = 'Help';
    }
    ApplicationComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.clientNameValue = localStorage.getItem('clientName');
        this.dtOptions = {
            pagingType: 'first_last_numbers',
            pageLength: 10,
            responsive: true,
        };
        // this.applicationService.CollectData().subscribe(result => 
        //   {
        //   this.AllData = result ;
        //   this.dtTrigger.next();
        //   });
        this.applicationService.CollectData(this.clientNameValue).subscribe(function (result) {
            _this.AllData = result;
            console.log(JSON.stringify(_this.AllData));
            _this.dtTrigger.next();
        });
    };
    ApplicationComponent.prototype.toggle = function () {
        this.show = !this.show;
        // CHANGE THE NAME OF THE BUTTON.
        if (this.show)
            this.buttonName = "Hide";
        else
            this.buttonName = "Help";
    };
    ApplicationComponent.prototype.exportTemplate = function () {
        var csvRows = [];
        console.log(this.AllData);
        var filename = "Application";
        var dateNow = new Date();
        var options = {
            // filename:"Application.csv",
            headers: ["ApplicationId", "Application Name", "Application Description", "IsCloudable", "MigrationPattern",
                "CloudProvider", "IsAssessment", "IsFinalized", "IsDeleted", "IsDeactivated", "DeleteDateAndTime",
                "Isverified", "CreatedDate", "ModifiedDateTime", "CreatedBy", "ModifiedBy", "UserId", "IsSaved"]
        };
        new Angular5_csv_1.Angular5Csv(this.applicationTemplate, filename, options);
    };
    ApplicationComponent.prototype.form = function () {
        this.router.navigate(['/application/add-application']);
    };
    ApplicationComponent.prototype.someClickHandler = function (info) {
        this.message = info.id + ' - ' + info.firstName;
    };
    ApplicationComponent.prototype.myFunction = function () {
        this.router.navigate(['/application/import-application']);
    };
    ApplicationComponent.prototype.editApplication = function (application) {
        console.log(JSON.stringify(application));
        this.applicationService.sendMsgtoOtherComponent(application);
        this.router.navigate(['/application/update-application']);
    };
    ApplicationComponent.prototype.exportCsv = function () {
        var csvRows = [];
        console.log(this.AllData);
        var filename = "Application";
        // const headers = this.AllData[0];
        // console.log("headers****"+headers);
        // var  DEFAULTFILENAME = 'mycsv.csv';
        var dateNow = new Date();
        console.log(dateNow.getDate().toString + " Date");
        console.log(dateNow.getDay().toString + " day");
        console.log(dateNow.getMonth().toString + " month");
        console.log(dateNow.getFullYear().toString + " year");
        for (var index = 0; index < this.AllData.length; index++) {
            console.log(this.AllData[index].applicationId + "id");
            this.application[index] = this.AllData[index];
            //  this.application[index].applicationName=this.AllData[index].applicationName;
            //  this.application[index].applicationDescription=this.AllData[index].applicationDescription;
            //  this.application[index].isCloudable=this.AllData[index].isCloudable;
            //  this.application[index].MigrationPattern=this.AllData[index].MigrationPattern;
            //  this.application[index].cloudProvider=this.AllData[index].cloudProvider;
            //  this.application[index].isAssessment=this.AllData[index].isAssessment;
            //  this.application[index].isFinalize=this.AllData[index].isFinalize;
            //  this.application[index].isDeleted=this.AllData[index].isDeleted;
            //  this.application[index].isDeactivate=this.AllData[index].isDeactivate;
        }
        console.log(this.application);
        // for (let index = 0; index < this.application.length; index++) {
        //   console.log(this.application[index]);
        // }
        var options = {
            // filename:"Application.csv",
            headers: ["ApplicationId", "Application Name", "Application Description", "IsCloudable", "MigrationPattern",
                "CloudProvider", "IsAssessment", "IsFinalized", "IsDeleted", "IsDeactivated", "DeleteDateAndTime",
                "Isverified", "CreatedDate", "ModifiedDateTime", "CreatedBy", "ModifiedBy", "UserId", "IsSaved"]
        };
        new Angular5_csv_1.Angular5Csv(this.application, filename, options);
    };
    ApplicationComponent.prototype.deleteApplication = function (formvalues) {
        var _this = this;
        this.applicationService.deleteApplications(formvalues)
            .subscribe(function (data) {
            console.log(data);
            //this.reloadData();
            //this.router.navigate(['/applictaion']);
            _this.reloadData();
            //this.getData.CollectData();
        }, function (error) { return console.log('ERROR: ' + error); });
        // this.router.navigate(['/applictaion']);
    };
    ApplicationComponent.prototype.resetApplication = function (formvalues) {
        this.applicationService.resetApplication(formvalues)
            .subscribe();
    };
    ApplicationComponent.prototype.reloadData = function () {
        this.applicationService.CollectData(this.clientNameValue);
    };
    ApplicationComponent.prototype.ViewApplication = function (formvalues) {
        this.applicationService.sendMsgtoOtherComponent(formvalues);
        console.log(formvalues);
        this.router.navigate(['/application/view-application']);
    };
    ApplicationComponent.prototype.assessApplication = function (formvalues) {
        console.log(JSON.stringify(formvalues));
        console.log(formvalues.applicationId);
        this.applicationService.sendMsgtoOtherComponent(formvalues);
        this.router.navigate(['/application/assesst-application']);
    };
    ApplicationComponent.prototype.deactivate = function (formvalues) {
        this.applicationService.deactivate(formvalues).subscribe();
    };
    ApplicationComponent.prototype.somefunction = function () {
        console.log("sommmmmmmmmmmmmmmmmmmmmmm");
    };
    ApplicationComponent = __decorate([
        core_1.Component({
            selector: 'app-application',
            templateUrl: './application.component.html',
            styleUrls: ['./application.component.scss']
        }),
        __metadata("design:paramtypes", [router_1.Router, application_service_1.ApplicationService, http_1.HttpClient])
    ], ApplicationComponent);
    return ApplicationComponent;
}());
exports.ApplicationComponent = ApplicationComponent;
//# sourceMappingURL=application.component.js.map