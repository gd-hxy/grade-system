//以下为修改jQuery Validation插件兼容Bootstrap的方法，没有直接写在插件中是为了便于插件升级
        $.validator.setDefaults({
            highlight: function (element) {
                $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
            },
            success: function (element) {
                element.closest('.form-group').removeClass('has-error').addClass('has-success');
            },
            errorElement: "span",
            errorPlacement: function (error, element) {
                if (element.is(":radio") || element.is(":checkbox")) {
                    error.appendTo(element.parent().parent().parent());
                } else {
                    error.appendTo(element.parent());
                }
            },
            errorClass: "help-block m-b-none",
            validClass: "help-block m-b-none"


        });

        $.validator.addMethod('filesize', function(value, element, param) {
            // param = size (in bytes)
            // element = element to validate (<input>)
            // value = value of the element (file name)
            return this.optional(element) || (element.files[0].size <= param)
        });
        //以下为官方示例
        $().ready(function () {
            // validate the comment form when it is submitted


            // validate signup form on keyup and submit
            var icon = "<i class='fa fa-times-circle'></i> ";
            $("#signupForm").validate({
                rules: {
                    oldPass: "required",
                    newPass: "required",
                    'checkBox[]': {
                        required:true,
                        maxlength:2
                    },
                    enterTime: {
                        required: true,
                        dateISO:true,
                        maxlength: 11
                    },
                    number:"required",
                    agree: "required"
                },
                messages: {
                    oldPass: icon + "请输入原密码",
                    newPass: icon + "请输入新密码",
                        'checkBox[]': {
                        required: icon + "必须选择图书的类型",
                        maxlength: icon + "最多选择两个类型"
                    },
                    enterTime: {
                        required: icon + "请输入入库日期",
                        maxlength: icon + "日期范围不符合规范",
                        dateISO: icon + "日期的格式必须为yyyy-mm-dd或者yyyy/mm/dd"
                    },
                    number: icon + "必须选择此图书入库的数量",
                    agree: {
                        required: icon + "必须同意协议后才能注册",
                        element: '#agree-error'
                    }
                }
            });

            // propose username by combining first- and lastname
            $("#username").focus(function () {
                var firstname = $("#firstname").val();
                var lastname = $("#lastname").val();
                if (firstname && lastname && !this.value) {
                    this.value = firstname + "." + lastname;
                }
            });
        });
