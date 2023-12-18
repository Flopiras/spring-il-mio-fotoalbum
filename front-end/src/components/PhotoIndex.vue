<script>
export default {
    data() {
        return {
            filteredPhotos: [],
            searchWord: ""
        }
    },

    props: {
        photos: Array,
    },

    emits: ["openShow"],

    methods: {
        filterPhotos() {
            // Converte la parola chiave di ricerca in minuscolo per una corrispondenza senza distinzione tra maiuscole e minuscole
            const searchLowerCase = this.searchWord.toLowerCase();

            // Filtra le foto in base al titolo
            this.filteredPhotos = this.photos.filter(photo => {
                // Converte il titolo della foto in minuscolo per una corrispondenza senza distinzione tra maiuscole e minuscole
                const titleLowerCase = photo.title.toLowerCase();

                // Restituisce true se il titolo contiene la parola chiave di ricerca
                return titleLowerCase.includes(searchLowerCase);
            });
        }
    },

}
</script >

<template>
    <h1 class="text-center my-4">Le nostre foto</h1>

    <!-- searchbar -->
    <form class="d-flex my-4" role="search" @submit.prevent="filterPhotos">
        <input v-model="searchWord" class="form-control me-2" type="search" placeholder="Cerca">
        <button class="btn btn-outline-success" type="submit">Cerca</button>
    </form>

    <!-- list -->
    <div v-if="searchWord === ''">
        <div class="row">
            <div v-for="photo in  photos " :key="photo.id" class="col my-3">
                <img @click="$emit('openShow', photo.id)" :src="photo.url" :alt="photo.title">
            </div>
        </div>
    </div>

    <div v-else>
        <div class="row">
            <div v-for="photo in filteredPhotos " :key="photo.id" class="col my-3">
                <img @click="$emit('openShow', photo.id)" :src="photo.url" :alt="photo.title">
            </div>
        </div>
    </div>
</template>

<style scoped>
img {
    cursor: pointer;
}
</style>