<template>
  <div style="width: 50%;margin: 50px 0">
    <el-form :model="data.user"  label-width="100px" label-position="right" style="padding-right: 40px">
        <el-form-item label="用户名" prop="username">
          <el-input  v-model="data.user.username" autocomplete="off"/>
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input  v-model="data.user.name" autocomplete="off"/>
        </el-form-item>
      <el-form-item label="电话" prop="phone">
        <el-input  v-model="data.user.phone" autocomplete="off"/>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input  v-model="data.user.email" autocomplete="off"/>
      </el-form-item>
      </el-form>
      <div style="text-align: center ;margin-top: 40px">
        <el-button type="primary" style="padding :20px 40px " @click="save">保存</el-button>
        </div>


  </div>
</template>

<script setup>
import {reactive,ref} from "vue"
import {Delete, Edit} from '@element-plus/icons-vue'
import request from "@/utils/request";
import {ElMessage, ElMessageBox} from "element-plus";

const data = reactive({
 user: JSON.parse(localStorage.getItem('user') || '{}')
})

const save = () => {
  request.put('/admin/update', data.user).then(res => {
    if (res.code === '200') {
      ElMessage.success('修改成功')
      localStorage.setItem('user', JSON.stringify(data.user))
    } else {
      ElMessage.error(res.msg)
    }
  })
}

</script>