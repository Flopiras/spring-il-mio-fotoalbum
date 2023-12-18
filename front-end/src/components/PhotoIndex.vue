<script>
export default {
    data() {
        return {

        }
    },

    props: {
        photos: Array,
    },

    emits: ["openShow"]
}
</script >

<template>
    <h1 class="text-center my-4">Le nostre foto</h1>

    <!-- list -->
    <div v-if="photos">
        <div class="row">
            <div v-for="photo in  photos " :key="photo.id" class="col my-3">
                <img @click="$emit('openShow', photo.id)" :src="photo.url" :alt="photo.title">
            </div>
        </div>
    </div>

    <h3 v-else class="text-center">Non ci sono foto disponibili</h3>
</template>

<style scoped>
img {
    cursor: pointer;
}
</style>