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
        this.AllData = [];
    }
    ApplicationComponent.prototype.ngOnInit = function () {
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
        this.applicationService.CollectData().subscribe(function (result) {
            _this.AllData = result;
            _this.dtTrigger.next();
            console.log(_this.AllData);
        });
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
        this.applicationService.CollectData();
    };
    ApplicationComponent.prototype.ViewApplication = function (formvalues) {
        this.applicationService.sendMsgtoOtherComponent(formvalues);
        console.log(formvalues);
        this.router.navigate(['/application/view-application']);
    };
    ApplicationComponent.prototype.assessApplication = function () {
        this.router.navigate(['/application/assesst-application']);
    };
    ApplicationComponent.prototype.deactivate = function (formvalues) {
        this.applicationService.deactivate(formvalues).subscribe();
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