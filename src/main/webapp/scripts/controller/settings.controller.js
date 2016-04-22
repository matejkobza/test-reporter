'use strict';

angular.module('app')
    .controller('SettingsController', function ($scope, service, $state) {

        var vm = this;
        vm.deleteSetting = deleteSetting;
        vm.goToUpdateSetting = goToUpdateSetting;
        vm.settings = [];

        function deleteSetting(subjects) {
            service.deleteSettings(subjects).then(function (response) {
                init();
            });
        }

        function goToUpdateSetting(settingId) {
            $state.go('settings.update', {id: settingId});
        }

        function init() {
            service.loadSettings().then(function (response) {
                vm.settings = response.data;
            });
        }

        init();

        return vm;
    });