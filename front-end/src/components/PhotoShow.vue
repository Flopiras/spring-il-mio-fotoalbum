<script>
export default {
    props: {
        photo: Object
    },

    emits: ["closeShow"]
}
</script>

<template>
    <!-- back button -->
    <button @click="$emit('closeShow')" class="btn btn-secondary my-4">Torna alla home</button>

    <h1 class="text-center mt-4">{{ photo.title }}</h1>

    <!-- image -->
    <div class="d-flex justify-content-center mb-4">
        <img :src="photo.url" :alt="photo.title" class="img-fluid">
    </div>

    <!-- description -->
    <div class="d-flex align-items-center flex-column">
        <h5>Descrizione</h5>
        <p>{{ photo.description }}</p>
    </div>
</template>