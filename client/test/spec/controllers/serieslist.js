'use strict';

describe('Controller: SerieslistCtrl', function () {

  // load the controller's module
  beforeEach(module('clientApp'));

  var SerieslistCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SerieslistCtrl = $controller('SerieslistCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(SerieslistCtrl.awesomeThings.length).toBe(3);
  });
});
