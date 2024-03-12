<template>
  <div>
    請輸入你要的短網址：
  <input type="text"> 
  <button @click="generate" >產生</button>
  <div>
  <a :href="shortUrl">{{shortUrl}}</a>

  </div>
  </div>
</template>

<script setup>
import axios from 'axios';
import {ref} from 'vue';

var shortUrl=ref("")

const generate = () => {
  axios.post('http://localhost:8080/hoxton/api', {
    url: 'https://ithelp.ithome.com.tw/articles/10253259',
    size: 7
  })
  .then((response) => {
    console.log(response.data);
    shortUrl.value ='http://localhost:8080/hoxton/api/'+response.data
  })
  .catch((error) => {
    console.error('Error:', error);
  });

}
</script>
