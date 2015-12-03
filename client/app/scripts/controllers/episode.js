'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('EpisodeCtrl', ['EpisodesFactory','$scope','SeriesFactory','$routeParams', function (EpisodesFactory,$scope,SeriesFactory,$routeParams) {
      var ecrud =  EpisodesFactory.crud();
      $scope.side1=true;
    $scope.id =$routeParams.id;
    SeriesFactory.query(function(data){
      $scope.series = data;
    });

      ecrud.get({id:$scope.id},function(data){
      $scope.episode = data;
      console.log($scope.episode.videomirror);
    });
    EpisodesFactory.getlatest(10).success(function(data){
      $scope.episodes = data;

    });
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  }]);
