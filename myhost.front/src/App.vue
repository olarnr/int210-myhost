<script>
const API_URL = `http://lvmolarn.sit.kmutt.ac.th:50000/api/host/hostname`

export default {
  data: () => ({
    date: null
  }),

  created() {
    // fetch on init
    this.fetchData()
  },

  methods: {
    async fetchData() {
      const url = `${API_URL}`
      this.hostname = await (await fetch(url)).json()
    }
  }
}
</script>

<template>
  <p>{{ hostname }}</p>
</template>
