'use strict';

describe('Controller: SerieCtrl', function () {

  // load the controller's module
  beforeEach(module('clientApp'));

  var SerieCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SerieCtrl = $controller('SerieCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(SerieCtrl.awesomeThings.length).toBe(3);
  });
});
