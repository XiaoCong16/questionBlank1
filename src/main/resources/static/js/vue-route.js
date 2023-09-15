const router = new VueRouter({
    routes: [
        {
            path: '/',
            name: 'home',
            component: import("../index.html")
        },
    ]
})
new Vue({
    router,
    render: h =>h(App),
}).$mount('#app')
