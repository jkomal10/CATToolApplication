"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var common_1 = require("@angular/common");
var angular_datatables_1 = require("angular-datatables");
var for_cloud_provider_routing_module_1 = require("./for-cloud-provider-routing.module");
var for_cloud_provider_component_1 = require("./for-cloud-provider.component");
var gitc_component_1 = require("./gitc/gitc.component");
var aws_component_1 = require("./aws/aws.component");
var set_evaluation_order_component_1 = require("./set-evaluation-order/set-evaluation-order.component");
var forms_1 = require("@angular/forms");
var cloud_provider_rule_component_1 = require("./cloud-provider-rule/cloud-provider-rule.component");
var ForCloudProviderModule = /** @class */ (function () {
    function ForCloudProviderModule() {
    }
    ForCloudProviderModule = __decorate([
        core_1.NgModule({
            imports: [common_1.CommonModule, for_cloud_provider_routing_module_1.ForCloudProviderRoutingModule, angular_datatables_1.DataTablesModule, forms_1.FormsModule],
            declarations: [for_cloud_provider_component_1.ForCloudProviderComponent, gitc_component_1.GitcComponent, aws_component_1.AwsComponent, set_evaluation_order_component_1.SetEvaluationOrderComponent, cloud_provider_rule_component_1.CloudProviderRuleComponent]
        })
    ], ForCloudProviderModule);
    return ForCloudProviderModule;
}());
exports.ForCloudProviderModule = ForCloudProviderModule;
//# sourceMappingURL=for-cloud-provider.module.js.map