import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MigrationPatternsComponent } from './migration-patterns.component';

describe('MigrationPatternsComponent', () => {
  let component: MigrationPatternsComponent;
  let fixture: ComponentFixture<MigrationPatternsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MigrationPatternsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MigrationPatternsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
