'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('MainCtrl', ['$scope', 'SeriesFactory', 'EpisodesFactory', function ($scope, SeriesFactory, EpisodesFactory) {
    $scope.id = 2;
    SeriesFactory.get({id: $scope.id}, function (data) {
      $scope.serie = data;
    });

    SeriesFactory.query(function (data) {
      $scope.series = data;
    });
    EpisodesFactory.getlatest(10).success(function (data){
      $scope.episodes = data;
    });

    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  }]);
