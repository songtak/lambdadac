<template>
    <div>
        <h3>검색결과 : {{count}}</h3>
        <v-simple-table>
            <template v-slot:default>
                <thead>
                <tr>
                    <th class="text-left">No.</th>
                    <th class="text-left">순위</th>
                    <th class="text-left">영화제목</th>
                    <th class="text-left">집계일</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item of navermovie" :key="item.movieSeq">
                    <td>{{ item.movieSeq }}</td>
                    <td>{{ item.rank }}</td>
                    <td>{{ item.title }}</td>
                    <td>{{ item.rankDate }}</td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div class="text-center" id="move">
            <div style="margin:0 auto; width: 300px; height: 100px">
            <span v-if="prev" style="width: 50px; height: 50px; border: 1px solid black">이전</span>
                <span v-for='i of arr' :key="i" style="width: 50px; height: 50px; border: 1px solid black">{{i}}</span>
            <span v-if="next" style="width: 50px; height: 50px; border: 1px solid black">다음</span>
            </div>
        </div>
    </div>

</template>

<script>
    import { mapState } from "vuex";
    export default {
        el:'#next',
        data() {
            return {
                prev: false,
                next: true,
                page: 1,
                arr: [1,2,3,4,5]
            };
        },
        computed: {
            ...mapState({
                navermovie: state => state.crawling.navermovie,
                count: state => state.crawling.count
            })
        }
    };
</script>

