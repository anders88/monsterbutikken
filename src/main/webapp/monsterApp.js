var monsterApp = angular.module("monsterButikken", ['ngRoute', 'ui.bootstrap'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/',
            {
                controller: 'LoginController',
                templateUrl: 'login.html'
            })
            .when('/butikken',
            {
                controller: 'MonsterController',
                templateUrl: 'butikken.html'
            })
}]);


monsterApp.run(['$rootScope', '$location', 'autentiseringService', function ($rootScope, $location, autentiseringService) {
    $rootScope.$on('$routeChangeStart', function () {

        autentiseringService.innloggetBruker().success(function(innloggetKunde){
            if (!innloggetKunde.kundenavn) {
                console.log('DENY');
                event.preventDefault();
                $location.path('/');
            }
            else {
                console.log('ALLOW');
                $location.path('/butikken');
            }
        })
    });
}]);