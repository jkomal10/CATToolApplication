import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CloudProviderRuleComponent } from './cloud-provider-rule.component';

describe('CloudProviderRuleComponent', () => {
  let component: CloudProviderRuleComponent;
  let fixture: ComponentFixture<CloudProviderRuleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CloudProviderRuleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CloudProviderRuleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
