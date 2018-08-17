import { ApiChartUiPage } from './app.po';

describe('api-chart-ui App', () => {
  let page: ApiChartUiPage;

  beforeEach(() => {
    page = new ApiChartUiPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
