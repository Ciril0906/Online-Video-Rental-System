@PreAuthorize("hasRole('ADMIN')") // Spring Security automatically prepends 'ROLE_'
@PostMapping
public ResponseEntity<Video> addVideo(@RequestBody Video video) {
    // ...
}

@PreAuthorize("hasRole('ADMIN')")
@PutMapping("/{id}")
public ResponseEntity<Video> updateVideo(@PathVariable Long id, @RequestBody Video video) {
    // ...
}

@PreAuthorize("hasRole('ADMIN')")
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteVideo(@PathVariable Long id) {
    // ...
}
