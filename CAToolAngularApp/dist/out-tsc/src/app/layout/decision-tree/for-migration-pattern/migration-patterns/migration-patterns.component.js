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
var for_migration_pattern_service_1 = require("../for-migration-pattern.service");
var router_1 = require("../../../../../../node_modules/@angular/router");
var http_1 = require("@angular/common/http");
var MigrationPatternsComponent = /** @class */ (function () {
    function MigrationPatternsComponent(forMigrationPatternService, router, http) {
        this.forMigrationPatternService = forMigrationPatternService;
        this.router = router;
        this.http = http;
        this.migrationAllData = [];
    }
    MigrationPatternsComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.forMigrationPatternService.question.subscribe(function (data) { _this.migrationIdValue = data; });
        this.forMigrationPatternService.getAssessmentQuestions().subscribe(function (result) {
            _this.migrationAllData = result;
            console.log(_this.migrationAllData);
            console.log(JSON.stringify(_this.migrationAllData));
        });
        console.log(this.migrationIdValue);
        console.log(this.migrationAllData.migrationRule[0].migrationId[0]);
    };
    MigrationPatternsComponent = __decorate([
        core_1.Component({
            selector: 'app-migration-patterns',
            templateUrl: './migration-patterns.component.html',
            styleUrls: ['./migration-patterns.component.scss']
        }),
        __metadata("design:paramtypes", [for_migration_pattern_service_1.ForMigrationPatternService, router_1.Router, http_1.HttpClient])
    ], MigrationPatternsComponent);
    return MigrationPatternsComponent;
}());
exports.MigrationPatternsComponent = MigrationPatternsComponent;
//# sourceMappingURL=migration-patterns.component.js.map