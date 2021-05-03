#include <stdio.h>
#include <pthread.h>

int arrFib[50]; //global variable

int calculateFib(int n){
    if (n == 0) {
        return 0;
    }
    if (n == 1) {
        return 1;
    }
    return calculateFib(n - 1) + calculateFib(n - 2);
}

void *worker (void *x){
    int pos = *((int *)x);
    arrFib[pos] = calculateFib(pos);
    pthread_exit(0);
}

int main (int ac, char **av){
    int input;

    if (ac == 2){
        if (sscanf (av [1], "%d", &input)== 1){

        }else fprintf(stderr, "Cannot translate argument\n");

    }else fprintf(stderr, "Invalid arguments\n");

    pthread_t tid[input];
    pthread_attr_t attr;
    pthread_attr_init (&attr);
    int i;
    for(i=0; i<input; i++){
        pthread_create(&tid[i], &attr , worker, &i);
    }

    for(i=0; i<input; i++){
        pthread_join(tid[i],NULL);
    }

    for(i=0; i<input; i++){
        printf("%d, ", arrFib[i]);
    }
    return (0);
}
