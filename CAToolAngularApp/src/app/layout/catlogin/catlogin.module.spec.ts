import { CatloginModule } from './catlogin.module';

describe('CatloginModule', () => {
  let catloginModule: CatloginModule;

  beforeEach(() => {
    catloginModule = new CatloginModule();
  });

  it('should create an instance', () => {
    expect(catloginModule).toBeTruthy();
  });
});
