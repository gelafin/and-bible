<!--
  - Copyright (c) 2021 Martin Denham, Tuomas Airaksinen and the And Bible contributors.
  -
  - This file is part of And Bible (http://github.com/AndBible/and-bible).
  -
  - And Bible is free software: you can redistribute it and/or modify it under the
  - terms of the GNU General Public License as published by the Free Software Foundation,
  - either version 3 of the License, or (at your option) any later version.
  -
  - And Bible is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
  - without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  - See the GNU General Public License for more details.
  -
  - You should have received a copy of the GNU General Public License along with And Bible.
  - If not, see http://www.gnu.org/licenses/.
  -->

<template>
  <div class="open-all" v-if="openAllLink">
    <a :href="openAllLink">{{strings.openAll}}</a>
  </div>
</template>

<script>
import {computed} from "vue";
import {inject} from "vue";
import {useCommon} from "@/composables";

export default {
  name: "OpenAllLink",
  props: {
    v11n: {type: String, default: null},
  },
  setup(props) {
    const referenceCollector = inject("referenceCollector", null);
    const openAllLink = computed(() => {
      if(referenceCollector === null) return null;
      const refs = referenceCollector.references;
      if(refs.length < 2) return null;
      return "multi://?" + refs.map(v => "osis=" + encodeURI(v.value)).join("&") + (props.v11n ? "&v11n=" + encodeURI(props.v11n): "")
    });
    return {openAllLink, ...useCommon()}
  }
}
</script>

<style scoped>
.open-all {
  padding-top: 1em;
  text-align: right;
}
</style>
