<template>
    <el-card style="width: 50%;margin-left: 50%;margin-top: 20%">
        <h1> 로그인 </h1>
    <el-form style="text-align: center">
        <el-form-item label="name">
            <el-input type="text" auto-complete="off" v-model="name"></el-input>
        </el-form-item>
        <el-form-item label="password">
            <el-input type="password" auto-complete="off" v-model="password"></el-input>
        </el-form-item>

        <el-row style="margin-top: 10%">
            <el-button @click="login">로그인</el-button>
            <el-button>회원가입</el-button>
            <el-button>이름/비밀번호 찾기</el-button>
        </el-row>
    </el-form>
    </el-card>
</template>

<script>
    import axios from '../plugins/axios'

    export default {
        name: "Login",
        data(){
            return{
                name:"",
                password:""
            }
        },
        methods:{
            login(){
                console.log('이름',this.name);
                console.log('비밀번호',this.password);
                const accountDto = {
                    name : this.name,
                    password : this.password
                };
                axios.post('login',accountDto)
                    .then((response) =>{
                        console.log(response);
                        this.getUser();
                    })
                    .catch((error) =>{
                        console.log(error);
                    })
            },
            getUser(){
                axios.get('user')
                    .then((response) =>{
                        console.log(response);
                    })
                    .catch((error) =>{
                        console.log(error);
                    })
            }
        }
    }
</script>

<style scoped>

</style>