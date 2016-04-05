'use strict';

angular.module('app')
    .controller('SettingsController', function ($scope, service, $state) {

        var vm = this;
        vm.deleteSetting = deleteSetting;
        vm.updateSetting = updateSetting;
        vm.findOneSetting = findOneSetting;
        vm.settings = [];

        function deleteSetting(subjects) {
            service.deleteSettings(subjects).then(function (response) {
                init();
            });
        }

        function updateSetting() {
            service.updateSettings(vm.settings).then(function (response) {
                $state.go('settings');
            });
        }

        function findOneSetting(subject) {
            $state.go('settings.update', {id: subject});
        }

        function init() {
            service.loadSettings().then(function (response) {
                vm.settings = response.data;
            });
        }

        init();

        return vm;
    });