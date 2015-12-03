'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:SerieCtrl
 * @description
 * # SerieCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('SerieCtrl', ['EpisodesFactory', '$scope', 'SeriesFactory','$routeParams', function (EpisodesFactory, $scope, SeriesFactory,$routeParams) {
    $scope.id = $routeParams.id;
      var ecrud =  EpisodesFactory.crud();
    SeriesFactory.get({id: $scope.id}, function (data) {
      $scope.serie = data;
    });

    SeriesFactory.query(function (data) {
      $scope.series = data;
    });
    EpisodesFactory.getlatest(10).success(function (data){
      $scope.episodes = data;
    });
      ecrud.get({id: $scope.id}, function (data) {
      $scope.episode = data;
    });
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  }]);
