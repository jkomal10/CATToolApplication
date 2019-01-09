import { ImportApplicationModule } from './import-application.module';

describe('ImportApplicationModule', () => {
  let importApplicationModule: ImportApplicationModule;

  beforeEach(() => {
    importApplicationModule = new ImportApplicationModule();
  });

  it('should create an instance', () => {
    expect(importApplicationModule).toBeTruthy();
  });
});
