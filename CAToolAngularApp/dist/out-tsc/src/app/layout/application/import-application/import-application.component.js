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
var Application_1 = require("../../decision-tree/reassessment/Application");
var application_service_1 = require("../application.service");
var router_1 = require("@angular/router");
var ImportApplicationComponent = /** @class */ (function () {
    function ImportApplicationComponent(router, applicationService) {
        this.router = router;
        this.applicationService = applicationService;
        this.extCheck = false;
        this.extation = ".csv";
        this.applications = new Application_1.Application();
        this.application = new Application_1.Application();
        this.lines = [];
    }
    ImportApplicationComponent.prototype.ngOnInit = function () {
    };
    ImportApplicationComponent.prototype.fileChangeListener = function (event) {
        var _this = this;
        this.filename = event.target.files[0].name;
        this.link = event.target.files[0];
        this.ext = this.filename.substring(this.filename.lastIndexOf('.')).toLowerCase();
        if (this.isCSVFile(this.ext)) {
            var reader_1 = new FileReader();
            reader_1.readAsText(this.link);
            reader_1.onload = function (data) {
                var csvData = reader_1.result;
                var csvRecordsArray = csvData.split(/\r|\n|\n/);
                var headersRow = _this.getHeaderArray(csvRecordsArray);
                _this.applications = _this.getDataRecordsArrayFromCSVFile(csvRecordsArray, headersRow.length);
            };
        }
        else {
            alert("please enter a csv file");
        }
        console.log(this.filename[0] + "___________");
        console.log(this.link + "**************");
    };
    ImportApplicationComponent.prototype.getDataRecordsArrayFromCSVFile = function (csvRecordsArray, headerLength) {
        for (var i_1 = 1; i_1 < csvRecordsArray.length; i_1++) {
            var data = csvRecordsArray[i_1].split(',');
            if (data.length == headerLength) {
                var dataArr = [];
                for (var j = 0; j < headerLength; j++) {
                    dataArr.push(data[j]);
                }
                this.lines.push(dataArr);
            }
        }
        console.log(this.lines.length);
        for (var i = 0; i < this.lines.length; i++) {
            console.log("adduser of row" + this.lines[i][0]);
        }
        return null;
    };
    ImportApplicationComponent.prototype.getHeaderArray = function (csvRecordsArr) {
        var headers = csvRecordsArr[0].split(',');
        var headerArray = [];
        for (var j = 0; j < headers.length; j++) {
            headerArray.push(headers[j]);
        }
        return headerArray;
    };
    ImportApplicationComponent.prototype.isCSVFile = function (extn) {
        this.extCheck = (extn === this.extation);
        return this.extCheck;
    };
    ImportApplicationComponent.prototype.importData = function () {
        for (var i = 0; i < this.lines.length; i++) {
            this.application.applicationId = this.lines[i][0];
            this.application.applicationName = this.lines[i][1];
            this.application.applicationDescription = this.lines[i][2];
            this.application.applicationType = this.lines[i][3];
            console.log("this.lines[i][0]" + this.lines[i][0]);
            console.log("this.lines[i][1]" + this.lines[i][1]);
            console.log("this.lines[i][2]" + this.lines[i][2]);
            console.log("this.lines[i][3]" + this.lines[i][3]);
            this.applicationService.createApplication(this.application)
                .subscribe();
            console.log("success");
            this.router.navigate(['/user']);
            console.log("----------this.userDetail" + this.application);
        }
        console.log("this.userDetail" + this.application);
    };
    ImportApplicationComponent = __decorate([
        core_1.Component({
            selector: 'app-import-application',
            templateUrl: './import-application.component.html',
            styleUrls: ['./import-application.component.scss']
        }),
        __metadata("design:paramtypes", [router_1.Router, application_service_1.ApplicationService])
    ], ImportApplicationComponent);
    return ImportApplicationComponent;
}());
exports.ImportApplicationComponent = ImportApplicationComponent;
//# sourceMappingURL=import-application.component.js.map