<script>
const API_URL = `http://lvmolarn.sit.kmutt.ac.th:50000/api/host/hostname`

export default {
  data: () => ({
    hostname: ""
  }),

  created() {
    // fetch on init
    this.fetchData()
  },

  methods: {
    async fetchData() {
      const url = `${API_URL}`
      try {
        let response = await fetch(url)
        if (response.ok) {
          this.hostname = await response.text()
        } else {
          this.hostname = "ERROR: " + response.statusText 
        }
      } catch (error) {
          this.hostname = "ERROR: Could not connect to " + url 
      }
    }
  }
}
</script>

<template>
{{ hostname }}
</template>
