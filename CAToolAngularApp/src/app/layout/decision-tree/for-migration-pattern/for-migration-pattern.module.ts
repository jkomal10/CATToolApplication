import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ForMigrationPatternRoutingModule } from './for-migration-pattern-routing.module';
import { ForMigrationPatternComponent } from './for-migration-pattern.component';

@NgModule({
    imports: [CommonModule, ForMigrationPatternRoutingModule],
    declarations: [ForMigrationPatternComponent]
})

export class ForMigrationPatternModule {}
